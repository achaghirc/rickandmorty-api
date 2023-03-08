package com.rickandmory.api.model;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

/**
 * This class test the class BaseInfo making a unit test of his methods getter and setter.
 */
public class BaseInfoTest {

    @Test
    public void testBaseInfo() {
        BaseInfo baseInfo = new BaseInfo();

        String name = "Name";
        String url = "url";

        baseInfo.setName(name);
        baseInfo.setUrl(url);

        MatcherAssert.assertThat(baseInfo.getName(), Matchers.is(name));
        MatcherAssert.assertThat(baseInfo.getUrl(), Matchers.is(url));

    }
}
