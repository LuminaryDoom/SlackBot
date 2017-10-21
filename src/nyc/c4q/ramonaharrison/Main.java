package nyc.c4q.ramonaharrison;
import nyc.c4q.ramonaharrison.network.Slack;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Bot myBot = new Bot();
        myBot.testApi();
        myBot.listChannels();
        int a=0;
        myBot.listMessages(Slack.BOTS_CHANNEL_ID);
//        while(a<25){
//
//            a++;
//        }
        // int a=0;
//       while(a<5){
//
//           a++;
//       }
        //myBot.sendMessageToBotsChannel(textChange("Test#hello"));
        //myBot.sendMessageToBotsChannel(textChange("Testhello"));
        //myBot.listMessages(Slack.BOTS_CHANNEL_ID);
        // myBot.listMessages(Slack.BOTS_CHANNEL_ID);
    }
//    public static String textChange(String str){
//       String link = "https://giphy.com/search/";
//
//
//       String text="";
//        String a=str;
//
//        for (int i=0; i<str.length(); i++){
//            //System.out.print(i+":");
//
//            if(str.charAt(i) == '#'){
//
//                for (int j = i+1;j<str.length() ;j++){
//                    text+=str.charAt(j);
//                }
//                a=link+text;
//            }
//
//        }
//
//        return a;
//    }
}