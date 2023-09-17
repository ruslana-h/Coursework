package cc.robotdreams.kanboard;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class DashboardPage
{
    final public SelenideElement createProject = Selenide.$x("//div[@class='page-header']/ul/li[1]/a");
    final public SelenideElement myProject = Selenide.$x("//div[@class='sidebar']/ul/li[1]/a");
    final public SelenideElement createdProject = Selenide.$x("//div[@class='table-list']//span/a");
    final public SelenideElement myTasks = Selenide.$x("//div[@class='sidebar']/ul/li[3]/a");
    final public SelenideElement createdTask = Selenide.$x("//div[4]/div[2]/div[1]/span/a");
    final public SelenideElement comment = Selenide.$x("//div/details[6]/summary");
    final public SelenideElement commentField = Selenide.$x("//textarea[@name='comment']");
    final public SelenideElement closeTask = Selenide.$x("//div[@class='sidebar sidebar-icons']/ul[2]/li[14]/a");
    final public SelenideElement confirmButton = Selenide.$x("//button[@id='modal-confirm-button']");






}
