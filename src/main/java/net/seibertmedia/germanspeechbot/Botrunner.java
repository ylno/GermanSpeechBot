package net.seibertmedia.germanspeechbot;

import static java.util.Locale.setDefault;

import java.util.Locale;
import java.util.Properties;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;

public class Botrunner {

  public static final String BOT_NAME = "bot-name";

  public static final String BOT_PATH = "bot-path";

  public static final String LANGUAGE = "language";

  public static final String COUNTRY = "country";

  private Bot bot;

  public String answerRequest(String request) {

    if(bot==null) {
      Properties properties = Botpropperties.readProperties();
      String language = properties.getProperty(LANGUAGE);
      String country = properties.getProperty(COUNTRY);
      Locale l = new Locale(language, country);
      setDefault(l);

      checkProperties(properties);
      bot = new Bot(properties.getProperty(BOT_NAME), properties.getProperty(BOT_PATH), "chat");
    }
    Chat chat = new Chat(bot, false, "10");
    return chat.multisentenceRespond(request);

  }

  private static void checkProperties(final Properties properties) {
    checkProperty(properties, BOT_NAME);
    checkProperty(properties, BOT_PATH);
  }

  private static void checkProperty(final Properties properties, final String parameterName) {
    if (properties.getProperty(parameterName) == null || properties.getProperty(parameterName).isEmpty()) {
      throw new RuntimeException("Parameter missing: " + parameterName + ". Please define it in settings.properties");
    }
  }
}
