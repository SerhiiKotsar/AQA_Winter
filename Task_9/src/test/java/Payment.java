import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Payment {

//1. Определяем UI-элементы сервиса https://next.privat24.ua/money-transfer/card для взаимодействия с ними

    //Элементы создания платежа (с карты)
    By debitCard = By.xpath("//input[@data-qa-node='numberdebitSource']");
    By expiredDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
    By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
    By senderFirstName = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
    By senderLastName = By.xpath("//input[@data-qa-node='lastNamedebitSource']");
    By amount = By.xpath("//input[@data-qa-node='amount']");
    By currencyButton = By.xpath("//button[@data-qa-node='currency']"); //выпадающий список выбора валюты
    By usdCheck = By.xpath("//button[@title='USD']"); // выбор валюты "USD"
    By uahCheck = By.xpath("//button[@title='UAH']"); // выбор валюты "UAH"
    By eurCheck = By.xpath("//button[@title='EUR']"); // выбор валюты "EUR"
    By submitButtonFirst = By.xpath("//button[@type='submit']"); // Кнопка "Переказаты"
    By submitButtonSecond = By.xpath("//button[@data-qa-node='submit']"); // Кнопка "Додати в кошик"

    //Элементы создания платежа (карта получателя)
    By creditCard = By.xpath("//input[@data-qa-node='numberreceiver']");
    By recipientFirstName = By.xpath("//input[@data-qa-node='firstNamereceiver']");
    By recipientLastName = By.xpath("//input[@data-qa-node='lastNamereceiver']");

    //Элементы корзины
    By deleteButton = By.xpath("//div[@class='sc-ipEyDJ iFKyLm']/button[@class='sc-csuSiG chgikK']"); //кнопка "Видалити"
    By submitBasketButton = By.xpath("//button[@data-qa-value='submit']"); //кнопка подтверждения удаления платежа из корзины
    By closeBasketButton = By.xpath("//button[@data-qa-node='close-button']"); // кнопка закрытия корзины
    By checkAmount = By.xpath("//div[@data-qa-node='amount']"); //поле с суммой платежа
    By checkDebitCard = By.xpath("//td[@data-qa-node='card']"); //поле с картой отправителя
    By checkCreditCard = By.xpath("//span[@data-qa-node='cardB']"); //поле с картой получателя
    By checkPaymentDetails = By.xpath("//div[@data-qa-node='details']"); // поле с назначением платежа

//2. Пишем тесты (JUnit)

    @BeforeEach
    public void init(){
        // 1. Создаем системную переменную в которую положили драйвер для системы.
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
    }

    @Test
    @DisplayName("Check min amount 10 USD")
    public void checkMinPayment(){
        // Создаем образ драйвера для взаимодействия.
        // Указываем ожидание элементов для взаимодействия с ними 10 секунд, если они не успели быстро загрузится.
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        // 2. Действия с элементами

        //2.1 Переходим на страницу перевода с карты на карту (экран полностью открыт)
        driver.manage().window().maximize();
        driver.get("https://next.privat24.ua/money-transfer/card");
        //2.2 Ищем поля для ввода данных об отправителе: номер карты/cvv/срок действия/имя и фамилия и заполняем их тестовыми значениями
        driver.findElement(debitCard).sendKeys("4567739561253907");
        driver.findElement(expiredDate).sendKeys("09/24");
        driver.findElement(cvv).sendKeys("528");
        driver.findElement(senderFirstName).sendKeys("RUTH");
        driver.findElement(senderLastName).sendKeys("MOTAIVO");
        //2.3 Ищем поля для ввода данных об получателе: номер карты/имя и фамилия и заполняем их тестовыми значениями
        driver.findElement(creditCard).sendKeys("4552331448138217");
        driver.findElement(recipientFirstName).sendKeys("SHAYNE");
        driver.findElement(recipientLastName).sendKeys("MCCONNELL");
        //2.4 Выбираем валюту USD и указываем минимальное значение в поле "Сумма" (min = 10)
        driver.findElement(amount).sendKeys("10");
        driver.findElement(currencyButton).click();
        driver.findElement(usdCheck).click();
        //2.5 Подтверждаем создание перевода нажатием кнопки "Переказати"
        driver.findElement(submitButtonFirst).submit();
        //2.6 Добавляем платеж в корзину нажатием кнопки "Додати в кошик"
        driver.findElement(submitButtonSecond).submit();

        // 3. Проверка ожидаемого результата с фактическим

        //3.1 Проверяем корректность отображения "Назначение платежа"
        Assertions.assertEquals("Переказ власних коштів.", driver.findElement(checkPaymentDetails).getText());
        //3.2 Проверяем корректность отображения карты отправителя
        Assertions.assertEquals("4567 **** **** 3907", driver.findElement(checkDebitCard).getText());
        //3.3 Проверяем корректность отображения карты получателя
        Assertions.assertEquals("4552 **** **** 8217", driver.findElement(checkCreditCard).getText());
        //3.4 Проверяем корректность отображения суммы платежа
        Assertions.assertEquals("10 USD", driver.findElement(checkAmount).getText());

        // 4. Удаляем платеж из корзины и закрываем корзину
        driver.findElement(deleteButton).click();
        driver.findElement(submitBasketButton).click();
        driver.findElement(closeBasketButton).click();

        // 5. Закрываем страницу браузера
        driver.quit();
    }

    @Test
    @DisplayName("Check max amount 29999 UAH")
    public void checkMaxPayment(){
        // Создаем образ драйвера для взаимодействия.
        // Указываем ожидание элементов для взаимодействия с ними 10 секунд, если они не успели быстро загрузится.
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        // 2. Действия с элементами

        //2.1 Переходим на страницу перевода с карты на карту (экран полностью открыт)
        driver.manage().window().maximize();
        driver.get("https://next.privat24.ua/money-transfer/card");
        //2.2 Ищем поля для ввода данных об отправителе: номер карты/cvv/срок действия/имя и фамилия и заполняем их тестовыми значениями
        driver.findElement(debitCard).sendKeys("4567739561253907");
        driver.findElement(expiredDate).sendKeys("09/24");
        driver.findElement(cvv).sendKeys("528");
        driver.findElement(senderFirstName).sendKeys("RUTH");
        driver.findElement(senderLastName).sendKeys("MOTAIVO");
        //2.3 Ищем поля для ввода данных об получателе: номер карты/имя и фамилия и заполняем их тестовыми значениями
        driver.findElement(creditCard).sendKeys("4552331448138217");
        driver.findElement(recipientFirstName).sendKeys("SHAYNE");
        driver.findElement(recipientLastName).sendKeys("MCCONNELL");
        //2.4 Выбираем валюту UAH и указываем максимальное значение в поле "Сумма" (max = 29999)
        driver.findElement(amount).sendKeys("29999");
        driver.findElement(currencyButton).click();
        driver.findElement(uahCheck).click();
        //2.5 Подтверждаем создание перевода нажатием кнопки "Переказати"
        driver.findElement(submitButtonFirst).submit();
        //2.6 Добавляем платеж в корзину нажатием кнопки "Додати в кошик"
        driver.findElement(submitButtonSecond).submit();

        // 3. Проверка ожидаемого результата с фактическим

        //3.1 Проверяем корректность отображения "Назначение платежа"
        Assertions.assertEquals("Переказ власних коштів.", driver.findElement(checkPaymentDetails).getText());
        //3.2 Проверяем корректность отображения карты отправителя
        Assertions.assertEquals("4567 **** **** 3907", driver.findElement(checkDebitCard).getText());
        //3.3 Проверяем корректность отображения карты получателя
        Assertions.assertEquals("4552 **** **** 8217", driver.findElement(checkCreditCard).getText());
        //3.4 Проверяем корректность отображения суммы платежа
        Assertions.assertEquals("29 999 UAH", driver.findElement(checkAmount).getText());

        // 4. Удаляем платеж из корзины и закрываем корзину
        driver.findElement(deleteButton).click();
        driver.findElement(submitBasketButton).click();
        driver.findElement(closeBasketButton).click();

        // 5. Закрываем страницу браузера
        driver.quit();
    }

    @Test
    @DisplayName("Check amount 200 EUR")
    public void checkMiddlePayment(){
        // Создаем образ драйвера для взаимодействия.
        // Указываем ожидание элементов для взаимодействия с ними 10 секунд, если они не успели быстро загрузится.
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        // 2. Действия с элементами

        //2.1 Переходим на страницу перевода с карты на карту (экран полностью открыт)
        driver.manage().window().maximize();
        driver.get("https://next.privat24.ua/money-transfer/card");
        //2.2 Ищем поля для ввода данных об отправителе: номер карты/cvv/срок действия/имя и фамилия и заполняем их тестовыми значениями
        driver.findElement(debitCard).sendKeys("4567739561253907");
        driver.findElement(expiredDate).sendKeys("09/24");
        driver.findElement(cvv).sendKeys("528");
        driver.findElement(senderFirstName).sendKeys("RUTH");
        driver.findElement(senderLastName).sendKeys("MOTAIVO");
        //2.3 Ищем поля для ввода данных об получателе: номер карты/имя и фамилия и заполняем их тестовыми значениями
        driver.findElement(creditCard).sendKeys("4552331448138217");
        driver.findElement(recipientFirstName).sendKeys("SHAYNE");
        driver.findElement(recipientLastName).sendKeys("MCCONNELL");
        //2.4 Выбираем валюту UAH и указываем среднее значение в поле "Сумма" (max = 200)
        driver.findElement(amount).sendKeys("200");
        driver.findElement(currencyButton).click();
        driver.findElement(eurCheck).click();
        //2.5 Подтверждаем создание перевода нажатием кнопки "Переказати"
        driver.findElement(submitButtonFirst).submit();
        //2.6 Добавляем платеж в корзину нажатием кнопки "Додати в кошик"
        driver.findElement(submitButtonSecond).submit();

        // 3. Проверка ожидаемого результата с фактическим

        //3.1 Проверяем корректность отображения "Назначение платежа"
        Assertions.assertEquals("Переказ власних коштів.", driver.findElement(checkPaymentDetails).getText());
        //3.2 Проверяем корректность отображения карты отправителя
        Assertions.assertEquals("4567 **** **** 3907", driver.findElement(checkDebitCard).getText());
        //3.3 Проверяем корректность отображения карты получателя
        Assertions.assertEquals("4552 **** **** 8217", driver.findElement(checkCreditCard).getText());
        //3.4 Проверяем корректность отображения суммы платежа
        Assertions.assertEquals("200 EUR", driver.findElement(checkAmount).getText());

        // 4. Удаляем платеж из корзины и закрываем корзину
        driver.findElement(deleteButton).click();
        driver.findElement(submitBasketButton).click();
        driver.findElement(closeBasketButton).click();

        // 5. Закрываем страницу браузера
        driver.quit();
    }

}
