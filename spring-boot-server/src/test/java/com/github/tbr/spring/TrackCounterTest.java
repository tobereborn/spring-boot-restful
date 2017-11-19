package com.github.tbr.spring;

import com.github.tbr.spring.config.TrackCounterConfig;
import com.github.tbr.spring.soundsystem.CompactDisc;
import com.github.tbr.spring.soundsystem.TrackCounter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TrackCounterConfig.class)
public class TrackCounterTest {

    @Autowired
    private CompactDisc cd;

    @Autowired
    private TrackCounter trackCounter;

    @Test
    public void test() {

        cd.playTrack(1);
        cd.playTrack(2);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(7);
        cd.playTrack(7);

        Assert.assertEquals(1, trackCounter.getPlayCount(1));
        Assert.assertEquals(1, trackCounter.getPlayCount(2));
        Assert.assertEquals(4, trackCounter.getPlayCount(3));
        Assert.assertEquals(0, trackCounter.getPlayCount(4));
        Assert.assertEquals(0, trackCounter.getPlayCount(5));
        Assert.assertEquals(0, trackCounter.getPlayCount(6));
        Assert.assertEquals(2, trackCounter.getPlayCount(7));
    }
}
