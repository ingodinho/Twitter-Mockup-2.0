package com.mockup.twitter.utils;

import com.google.common.hash.Hashing;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class HashingService {

    public HashingService(){}
    public String getHashString(String givenString) {
        return Hashing.sha256().hashString(givenString, StandardCharsets.UTF_8).toString();
    }

    public String createRandomHash() {
        String randomString = Double.toString(Math.random());
        return getHashString(randomString);
    }
}
