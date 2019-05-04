package Java_Tests;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.Attachment;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.Augmenter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("JavadocType")
public class Step_Listener extends Test_Prepare implements StepLifecycleListener {

    private String createScreen() {
        File screenshot = ((TakesScreenshot)(new Augmenter().augment(driver)))
                .getScreenshotAs(OutputType.FILE);

        BufferedImage img = null;
        try {
            img = ImageIO.read(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Date dat = new Date();
        DateFormat formatForDateNow = new SimpleDateFormat("yyyy-mm-dd hh.mm.ss");
        String path = new File("screen").getAbsolutePath();
        System.out.println(path);

        path += "\\" + formatForDateNow.format(dat) + ".png";

        byte[] bytes = null;
        try {
            File to = new File(path);
            ImageIO.write(img, "png", to);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return path;
    }

    @Override
    public void beforeStepStart(final StepResult result) {
        Attachment att = new Attachment();
        att.setType("image/png");
        att.setSource(createScreen());
        result.withAttachments(att);
    }

    @Override
    public void beforeStepStop(final StepResult result) {
        Attachment att = new Attachment();
        att.setType("image/png");
        att.setSource(createScreen());
        result.withAttachments(att);
    }

}

