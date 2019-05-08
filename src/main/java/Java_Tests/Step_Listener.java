package Java_Tests;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.Attachment;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.Augmenter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

@SuppressWarnings("JavadocType")
public class Step_Listener extends Test_Prepare implements StepLifecycleListener {

    private String createScreen() {
        File screenshot = ((TakesScreenshot)(new Augmenter().augment(driver)))
                .getScreenshotAs(OutputType.FILE);

        SimpleDateFormat timeScreen = new SimpleDateFormat("HH.mm.ss");
        String date = timeScreen.format(new Date());
        String path = new File("screen").getAbsolutePath();

        path += "\\screenshot " + date + ".png";

        try {
            BufferedImage img = ImageIO.read(screenshot);
            File to = new File(path);
            ImageIO.write(img, "png", to);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }

    private void attach(final StepResult result) {
        Attachment att = new Attachment();
        att.setType("image/png");
        att.setSource(createScreen());
        result.withAttachments(att);
    }

    @Override
    public void beforeStepStart(final StepResult result) {
        attach(result);
    }

    @Override
    public void beforeStepStop(final StepResult result) {
        attach(result);
    }
}

