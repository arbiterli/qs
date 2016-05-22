package com.glority.qualityserver.web.service.key;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.glority.qualityserver.AbstractBaseControllerTest;
import com.glority.qualityserver.Constants;
import com.glority.qualityserver.ServerSettings;

/**
 * DefaultKeyAuthService Test.
 * 
 * @author Administrator
 * 
 */
public class DefaultKeyAuthServiceTest extends AbstractBaseControllerTest {
    private String defaultAuthKey = ServerSettings.getInstance().getSetting(KeyAuthService.SERVER_DEFAULT_AUTH_KEY);

    @Test
    public void uploadReport() throws Exception {
        String wrongKey = "wrongKey";

        MockMultipartFile wrongFile = new MockMultipartFile("xml", "orgfilename", null, "bar".getBytes());
        MockMultipartFile rightFile = new MockMultipartFile("xml", DefaultKeyAuthServiceTest.class.getClassLoader()
                .getResourceAsStream("quality.xml"));

        this.executeFileUpload(wrongKey, wrongFile).andExpect(status().isOk())
                .andExpect(content().string(Constants.ERROR));

        this.executeFileUpload(wrongKey, rightFile).andExpect(status().isOk())
                .andExpect(content().string(Constants.ERROR));

        this.executeFileUpload(this.defaultAuthKey, wrongFile).andExpect(status().isOk())
                .andExpect(content().string(Constants.ERROR));

        this.executeFileUpload(this.defaultAuthKey, rightFile).andExpect(status().isOk())
                .andExpect(content().string(Constants.SUCCESS));
    }

    private ResultActions executeFileUpload(String key, MockMultipartFile file) throws Exception {
        final String keyParamName = "key";
        return super.build().perform(
                MockMvcRequestBuilders.fileUpload("/service/key/upload").file(file).param(keyParamName, key));
    }

    @Test
    public void testReportQualityEngineFailure() throws Exception {
        String params = "?key=" + this.defaultAuthKey + "&task=" + "testTask" + "&owner=" + "testOwner"
                + "&stacktrace=" + "stacktrace";
        get("/service/key/reportQualityEngineFailure" + params).andExpect(status().isOk()).andExpect(
                content().string(Constants.SUCCESS));
    }

}
