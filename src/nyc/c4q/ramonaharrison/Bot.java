package nyc.c4q.ramonaharrison;
import jdk.nashorn.internal.parser.JSONParser;
import nyc.c4q.ramonaharrison.model.Channel;
import nyc.c4q.ramonaharrison.model.Message;
import nyc.c4q.ramonaharrison.network.*;
import nyc.c4q.ramonaharrison.network.response.*;
import org.json.simple.JSONObject;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Ramona Harrison
 * on 8/26/16
 *
 */
public class Bot {
    // TODO: implement your bot logic!
    public void Bot(){
//    sendMessageToBotsChannel("Test#hello");
    }
    /**
     * Sample method: tests the Slack API. Prints a message indicating success or failure.
     */
    public void testApi() {
        Response apiTest = Slack.testApi();
        System.out.println("API OK: " +apiTest.isOk() + "\n");
    }
    /**
     * Sample method: prints all public AccessCode3-3 channel names and ids. Prints an error message on failure.
     */
    public void listChannels() {
        ListChannelsResponse listChannelsResponse = Slack.listChannels();
        if (listChannelsResponse.isOk()) {
            List<Channel> channels = listChannelsResponse.getChannels();
            System.out.println("\nChannels: ");
            for (Channel channel : channels) {
                System.out.println("name: " + channel.getName() + ", id:" + channel.getId());
            }
        } else {
            System.err.print("Error listing channels: " + listChannelsResponse.getError());
        }
    }
    /**
     * Sample method: prints up to the last 100 messages from a given channel. Prints an error message on failure.
     * or failure.
     *
     * @param channelId id of the given channel.
     */
    public void listMessages(String channelId) {
        ListMessagesResponse listMessagesResponse = Slack.listMessages(channelId);
        if (listMessagesResponse.isOk()) {
            List<Message> messages = listMessagesResponse.getMessages();
            System.out.println("SIZE OF LIST: "+messages.size());
            System.out.println("\nMessages: ");
            for (Message message : messages) {
                System.out.println();
                System.out.println("Timestamp: " + message.getTs());
                System.out.println("Message: " + message.getText());
                if (message.getText().contains("U7KEUGNFQ")) {
                    String link = "https://giphy.com/search/";
                    String str = message.getText();
                    String text = "";
                    String a = "";
                    for (int i = 0; i < str.length(); i++) {
                        //System.out.println("loop1");
                        // System.out.print(i+":");
                        if (str.charAt(i) == '#') {
                            // System.out.println("entered if statement");
                            for (int j = i + 1; j < str.length(); j++) {
                                //System.out.println("");
                                if (str.charAt(j) == ' ') {
                                    break;
                                }
                                text += str.charAt(j);
                                //System.out.println("THISSSSSSS isss the text:  "+text);
                            }
                            //System.out.println("printing out "+ link+text);
                            sendMessageToBotsChannel(link + text);
                            break;
                        }
                    }
                    //sendMessageToBotsChannel(a);
                    break;
//                    if(message.getText().contains("hello")){
//                        sendMessageToBotsChannel("once");
//                        break;
//                    }
//                    sendMessageToBotsChannel("Test#hello");
//                    break;
                }
            }
        } else {
            System.err.print("Error listing messages: " + listMessagesResponse.getError());
        }
    }
    /**
     * Sample method: sends a plain text message to the #bots channel. Prints a message indicating success or failure.
     *
     * @param text message text.
     */
    public void sendMessageToBotsChannel(String text) {
        SendMessageResponse sendMessageResponse = Slack.sendMessage(text);
        if (sendMessageResponse.isOk()) {
            System.out.println("Message sent successfully!");
        } else {
            System.err.print("Error sending message: " + sendMessageResponse.getError());
        }
    }
    /**
     * Sample method: deletes a message from the #bots channel. Prints a message indicating success or failure.
     *
     * @param messageTs unique timestamp of the message to be deleted.
     */
    public void deleteMessageInBotsChannel(String messageTs) {
        DeleteMessageResponse deleteMessageResponse = Slack.deleteMessage(messageTs);
        if (deleteMessageResponse.isOk()) {
            System.out.println("Message deleted successfully!");
        } else {
            System.err.print("Error sending message: " + deleteMessageResponse.getError());
        }
    }
}

