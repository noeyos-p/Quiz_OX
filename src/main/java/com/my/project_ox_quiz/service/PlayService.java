package com.my.project_ox_quiz.service;

import com.my.project_ox_quiz.entity.Play;
import com.my.project_ox_quiz.repository.PlayRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Transactional
public class PlayService {
    private final PlayRepository playRepository;

    public PlayService(PlayRepository playRepository) {
        this.playRepository = playRepository;
    }

    public void savePlay(String userId, boolean correct) {
        Play play = new Play();
        play.setUser(userId);
        play.setDate(new Date());

        if (correct) {
            play.setYes("1");
            play.setNo("0");
        } else {
            play.setYes("0");
            play.setNo("1");
        }

        playRepository.save(play);
    }
}
