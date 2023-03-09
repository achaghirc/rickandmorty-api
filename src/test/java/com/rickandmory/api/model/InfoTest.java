package com.rickandmory.api.model;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InfoTest {

    @Test
    public void testInfo() {

        Info info = new Info();

        String count = "count";
        String pages = "pages";
        String next = "next";
        String prev = "prev";

        info.setCount(count);
        info.setPages(pages);
        info.setNext(next);
        info.setPrev(prev);


        MatcherAssert.assertThat(info.getCount(), Matchers.is(count));
        MatcherAssert.assertThat(info.getPages(), Matchers.is(pages));
        MatcherAssert.assertThat(info.getNext(), Matchers.is(next));
        MatcherAssert.assertThat(info.getPrev(), Matchers.is(prev));

    }
}
