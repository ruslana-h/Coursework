package cc.robotdreams.kanboard.ui;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class DashboardPage
{
    final public SelenideElement myProject = Selenide.$x("//div[@class='sidebar']/ul/li[1]/a");
    final public SelenideElement returnToDashboard = Selenide.$x("//div/h1/span/a[@title = 'Dashboard']");
    final public SelenideElement createdProject = Selenide.$x("//div[@class='table-list']//span/a");
    final public SelenideElement myTasks = Selenide.$x("//div[@class='sidebar']/ul/li[3]/a");
    final public SelenideElement createdTask = Selenide.$x("//*[@id='dashboard']/div[2]/div[2]/div[2]/div[1]/span/a");
    final public SelenideElement comment = Selenide.$x("//div/details[6]/summary");
    final public SelenideElement commentField = Selenide.$x("//textarea[@name='comment']");
    final public SelenideElement addedComment = Selenide.$x("//div[@class='comment-content']//p");
    final public SelenideElement closeTask = Selenide.$x("//div[@class='sidebar sidebar-icons']/ul[2]/li[14]/a");
    final public SelenideElement confirmButton = Selenide.$x("//button[@id='modal-confirm-button']");
    final public SelenideElement status = Selenide.$x("//section[@id='task-summary']//span[contains(text(), 'closed')]");






}
