package com.nelson.powermock.spy.resource;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import java.io.File;

public class FileServiceTest {

    @Test
    public void testWrite() throws Exception {
        FileService fileService = PowerMockito.mock(FileService.class);
        fileService.write("nelson");
    }

    @Test
    public void testWriteSpy() {
        FileService fileService = PowerMockito.spy(new FileService());
        fileService.write("nelson");
        File file = new File(System.getProperty("user.dir") + "haoxunwang.txt");
        Assert.assertTrue(file.exists());

    }

}