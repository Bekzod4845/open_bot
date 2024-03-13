package com.ompany.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.webapp.WebAppInfo;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.LinkedList;
import java.util.List;

public class MyBot extends TelegramLongPollingBot  {

    @Override
    public String getBotUsername() {
        return "toshariq_open_budget_bot";
    }

    //5.7.1 -> 6.5 shunday
//    @Override
//    public String getBotToken() {
//        return "";
//    }


    // 6/5 dan kottasi bolsa shu
    public MyBot() throws TelegramApiException {
        super("7069444275:AAHgOKRewfoNZD6RNC2gwl-OYlipYG34ZSE");
    }


    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            if(update.getMessage().getText().equals("/start")){
                 SendMessage sendMessage = new SendMessage();
                 sendMessage.setChatId(update.getMessage().getChatId());
                 sendMessage.setText(String.format("Assalomu aleykum %s xush kelibsiz",update.getMessage().getFrom().getUserName()));
                 sendMessage.setReplyMarkup(getInlineKeyboardMarkup());
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    private static InlineKeyboardMarkup getInlineKeyboardMarkup() {
        List< List<InlineKeyboardButton>> rowList = new LinkedList<>();
        List< InlineKeyboardButton> row = new LinkedList<>();

        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Ovoz berish");
        button.setWebApp(new WebAppInfo("https://openbudget.uz/boards/initiatives/initiative/32/33591959-7a70-41cc-b4f2-930f3f288d18"));
        row.add(button);
        rowList.add(row);
        InlineKeyboardMarkup inlineKeyboardMarkub = new InlineKeyboardMarkup( );
        inlineKeyboardMarkub.setKeyboard(rowList);
        return inlineKeyboardMarkub;
    }
}
