package testingBrowser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TestingOpen {
    static Playwright playwright;
    static Browser browser;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @Test
    void shouldHaveCorrectTitle() {
        Page page = browser.newPage();
        // 1. Открываем веб-страницу
        page.navigate("");

        // 2. Проверяем, что заголовок соответствует ожидаемому
        // Ожидаемый заголовок: "Fast and reliable end-to-end testing for modern web apps"
        assertThat(page).hasTitle("Fast and reliable end-to-end testing for modern web apps");

        page.close();
    }
}