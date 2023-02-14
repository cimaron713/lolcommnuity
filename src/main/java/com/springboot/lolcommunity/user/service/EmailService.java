package com.springboot.lolcommunity.user.service;

public interface EmailService {
    String sendSimpleMessage(String to)throws Exception;
}