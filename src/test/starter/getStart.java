package test.starter;

import dev.langchain4j.model.openai.OpenAiChatModel;

import static dev.langchain4j.model.openai.OpenAiChatModelName.GPT_4_O_MINI;

public class getStart
{
    public static void main(String[] args){
        String apiKey = "demo";
        OpenAiChatModel model = OpenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName(OpenAiChatModelName.GPT_4_O_MINI)
                .build();
        String answer = model.generate("你好，我是谁？");
        System.out.println(answer);
    }
}
