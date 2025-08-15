package com.jafar.portfolio.service;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class MyQuoteApiService {

    private static final List<String> motivationalQuotes = Arrays.asList(
            "Don’t watch the clock; do what it does. Keep going.",
            "Small steps every day lead to big results.",
            "It always seems impossible until it’s done.",
            "Your limitation—it’s only your imagination.",
            "Great things never come from comfort zones.",
            "If you’re not willing to risk the unusual, you’ll have to settle for the ordinary.",
            "Fall seven times and stand up eight.",
            "Your mind is a powerful thing. When you fill it with positive thoughts, your life will start to change.",
            "Success is not final, failure is not fatal: It is the courage to continue that counts.",
            "Believe you can and you’re halfway there.",
            "Dream it. Wish it. Do it.",
            "Do something today that your future self will thank you for.",
            "Don’t wait for opportunity. Create it.",
            "Push yourself, because no one else is going to do it for you.",
            "The harder you work for something, the greater you’ll feel when you achieve it.",
            "Dream bigger. Do bigger.",
            "Don’t limit your challenges. Challenge your limits.",
            "Sometimes later becomes never. Do it now.",
            "Great things take time. Be patient and persistent.",
            "Don’t stop until you’re proud.",
            "Your only limit is your mind.",
            "Focus on progress, not perfection.",
            "Mistakes are proof that you are trying.",
            "Start where you are. Use what you have. Do what you can.",
            "Believe in yourself and all that you are.",
            "Strive for progress, not perfection.",
            "The key to success is to start before you are ready.",
            "Hustle in silence and let your success make the noise.",
            "Opportunities don’t happen. You create them.",
            "Do what you can with what you have where you are.",
            "Success doesn’t just find you. You have to go out and get it.",
            "Don’t be afraid to give up the good to go for the great.",
            "Success is the sum of small efforts repeated day in and day out.",
            "The secret of getting ahead is getting started.",
            "Don’t be pushed around by the fears in your mind. Be led by the dreams in your heart.",
            "Believe it can be done. When you believe something can be done, really believe, your mind will find the ways to do it.",
            "Act as if what you do makes a difference. It does.",
            "Great things are done by a series of small things brought together.",
            "Don’t let yesterday take up too much of today.",
            "You don’t have to be great to start, but you have to start to be great.",
            "The only way to achieve the impossible is to believe it is possible.",
            "Success is not for the lazy.",
            "Your future is created by what you do today, not tomorrow.",
            "Work hard in silence. Let success be your noise.",
            "Stop waiting for things to happen. Make them happen.",
            "Do what is right, not what is easy nor what is popular.",
            "Your dreams don’t work unless you do.",
            "The best way to predict your future is to create it.",
            "Fall in love with the process, and the results will come.",
            "Be stronger than your strongest excuse.",
            "Sometimes the smallest step in the right direction ends up being the biggest step of your life.",
            "Don’t be afraid to fail. Be afraid not to try.",
            "It’s not about having time. It’s about making time.",
            "Push yourself, because no one else is going to do it for you.",
            "Be so good they can’t ignore you.",
            "Doubt kills more dreams than failure ever will.",
            "The pain you feel today will be the strength you feel tomorrow.",
            "Don’t quit. Suffer now and live the rest of your life as a champion.",
            "Whatever you are, be a good one.",
            "The best time to start was yesterday. The next best time is now.",
            "Energy and persistence conquer all things.",
            "Do one thing every day that scares you.",
            "You are stronger than you think.",
            "The difference between ordinary and extraordinary is that little extra."
    );


    public String getRandomQuote() {
        Random random = new Random();
        return motivationalQuotes.get(random.nextInt(motivationalQuotes.size()));
    }

}

