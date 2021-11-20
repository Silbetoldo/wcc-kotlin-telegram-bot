package bots

import com.vdurmont.emoji.Emoji
import com.vdurmont.emoji.EmojiParser
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendAudio
import org.telegram.telegrambots.meta.api.methods.send.SendDocument
import org.telegram.telegrambots.meta.api.objects.InputFile
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException

import org.telegram.telegrambots.meta.api.objects.media.InputMediaAnimation
import java.io.File

class WCCBot : TelegramLongPollingBot() {

    //Função que recebe o nome do bot
    override fun getBotUsername(): String {
        //return bot username
        // If bot username is @HelloKotlinBot, it must return
        return "ChefSil_bot"
    }

    //Função que recebe o token do bot
    override fun getBotToken(): String {
        // Return bot token from BotFather
        return "2115201033:AAGuvA4pdX4yPL23rfSYFI4Crg25bkMzXWQ"
    }

    //Função que recebe a entrada do usuario
    override fun onUpdateReceived(update: Update?) {
        // We check if the update has a message and the message has text
        val nameSender = update?.message?.from?.firstName
        val chatId = update?.message?.chatId.toString()
        val messageCommand = update?.message?.text?.lowercase()
        val media = getFile(messageCommand, nameSender)


        try {
            if (messageCommand == "/frango" || messageCommand == "/calabresa" || messageCommand == "/bacon" ||
                messageCommand == "/florestanegra" || messageCommand == "/coco" || messageCommand == "/chocolate" ||
                messageCommand == "/bombom" || messageCommand == "/maracuja" || messageCommand == "/pacoquinha" ||
                messageCommand == "/burrito" || messageCommand == "/coxinha" || messageCommand == "/pastel")
            {
            val sendTeste = SendDocument().apply {
                this.chatId = chatId
                this.document = media
            }
            execute(sendTeste)
        }
            if (messageCommand == "/info" ){
                val sendInfo = SendDocument().apply {
                    this.chatId = chatId
                    this.caption = getMessage(messageCommand, nameSender)
                    this.document = InputFile().setMedia("https://i.pinimg.com/originals/15/2b/7b/152b7b9b03eafdc17e2cf69c57fcfe0b.gif")
                    this.parseMode = "MarkdownV2"

                }
                execute(sendInfo)
            }

                if (messageCommand == "/pizzas" ){
                    val sendPizza = SendDocument().apply {
                        this.chatId = chatId
                        this.caption = getMessage(messageCommand, nameSender)
                        this.document = InputFile().setMedia("https://media2.giphy.com/media/4ayiIWaq2VULC/giphy.gif")
                        this.parseMode = "MarkdownV2"

                    }
                    execute(sendPizza)
            }
            if (messageCommand == "/doces" ){
                val sendDoces = SendDocument().apply {
                    this.chatId = chatId
                    this.caption = getMessage(messageCommand, nameSender)
                    this.document = InputFile().setMedia("https://c.tenor.com/P8RPYeDbtUYAAAAM/celebrare-food-bike-celebrare.gif")
                    this.parseMode = "MarkdownV2"

                }

                execute(sendDoces)
            }
            if (messageCommand == "/salgados" ){
                val sendSalgados = SendDocument().apply {
                    this.chatId = chatId
                    this.caption = getMessage(messageCommand, nameSender)
                    this.document = InputFile().setMedia("https://c.tenor.com/ncZ1zn7wL64AAAAC/cute4-chickennuggets.gif")
                    this.parseMode = "MarkdownV2"

                }
                execute(sendSalgados)
            }
            if (messageCommand == "/bolos" ){
                val sendBolos = SendDocument().apply {
                    this.chatId = chatId
                    this.caption = getMessage(messageCommand, nameSender)
                    this.document = InputFile().setMedia("https://c.tenor.com/eypyfu3kWlMAAAAC/bolo-cake.gif")
                    this.parseMode = "MarkdownV2"

                }
                execute(sendBolos)
            }
            else {
                if (messageCommand == "/inicio" || messageCommand == "/start" ){
            val sendDocument = SendDocument().apply {
                this.chatId = chatId
                this.caption = getMessage(messageCommand, nameSender)
                this.document = InputFile().setMedia("https://c.tenor.com/HaZenuDR_IAAAAAC/fome-comida.gif")
                this.parseMode = "MarkdownV2"

            }
            execute(sendDocument)
        }
            }
    } catch (e: TelegramApiException)
    {
        e.printStackTrace()
    }
}

    private fun getFile(messageCommand: String?, nameSender: String?) : InputFile = when(messageCommand) {
                "/frango" -> InputFile().setMedia(File("C:\\Users\\silbe\\Repositorios Git\\Curso Kotlin - WCC-Stilingue\\wcc-kotlin-telegram-bot\\src\\main\\resources\\pizzas\\Pizza de frango com queijo.txt"))
                "/calabresa" -> InputFile().setMedia(File("C:\\Users\\silbe\\Repositorios Git\\Curso Kotlin - WCC-Stilingue\\wcc-kotlin-telegram-bot\\src\\main\\resources\\pizzas\\Pizza de calabresa.txt"))
                "/bacon" -> InputFile().setMedia(File("C:\\Users\\silbe\\Repositorios Git\\Curso Kotlin - WCC-Stilingue\\wcc-kotlin-telegram-bot\\src\\main\\resources\\pizzas\\Pizzadebacon.txt"))
                "/florestanegra" -> InputFile().setMedia(File("C:\\Users\\silbe\\Repositorios Git\\Curso Kotlin - WCC-Stilingue\\wcc-kotlin-telegram-bot\\src\\main\\resources\\bolos\\Bolo floresta negra sem gluten.txt"))
                "/coco" -> InputFile().setMedia(File("C:\\Users\\silbe\\Repositorios Git\\Curso Kotlin - WCC-Stilingue\\wcc-kotlin-telegram-bot\\src\\main\\resources\\bolos\\Bolo gelado de coco.txt"))
                "/chocolate" -> InputFile().setMedia(File("C:\\Users\\silbe\\Repositorios Git\\Curso Kotlin - WCC-Stilingue\\wcc-kotlin-telegram-bot\\src\\main\\resources\\bolos\\Bolo Pudim de Chocolate.txt"))
                "/bombom" -> InputFile().setMedia(File("C:\\Users\\silbe\\Repositorios Git\\Curso Kotlin - WCC-Stilingue\\wcc-kotlin-telegram-bot\\src\\main\\resources\\doces\\BOMBOM DE AMENDOIM.txt"))
                "/maracuja" -> InputFile().setMedia(File("C:\\Users\\silbe\\Repositorios Git\\Curso Kotlin - WCC-Stilingue\\wcc-kotlin-telegram-bot\\src\\main\\resources\\doces\\CHEESECAKE DE MARACUJÁ .txt"))
                "/pacoquinha" -> InputFile().setMedia(File("C:\\Users\\silbe\\Repositorios Git\\Curso Kotlin - WCC-Stilingue\\wcc-kotlin-telegram-bot\\src\\main\\resources\\doces\\PAÇOQUINHA AMENDOIM E CHOCOLATE.txt"))
                "/burrito" -> InputFile().setMedia(File("C:\\Users\\silbe\\Repositorios Git\\Curso Kotlin - WCC-Stilingue\\wcc-kotlin-telegram-bot\\src\\main\\resources\\salgados\\Burrito de queijo com frango.txt"))
                "/coxinha" -> InputFile().setMedia(File("C:\\Users\\silbe\\Repositorios Git\\Curso Kotlin - WCC-Stilingue\\wcc-kotlin-telegram-bot\\src\\main\\resources\\salgados\\Coxinha de frango doce.txt"))
                "/pastel" -> InputFile().setMedia(File("C:\\Users\\silbe\\Repositorios Git\\Curso Kotlin - WCC-Stilingue\\wcc-kotlin-telegram-bot\\src\\main\\resources\\salgados\\Pastel de forno de batata doce.txt"))
        else -> InputFile().setMedia("testando")
    }
    private fun getMessage( command: String?, nameSender: String?) = when(command) {
        "/inicio" , "/start" -> welcome(nameSender)
        "/info" -> sobre()
        "/pizzas" -> pizza()
        "/doces" -> doces()
        "/salgados" -> salgados()
        "/bolos" -> bolos()
         else -> EmojiParser.parseToUnicode("testando")
    }
        private fun welcome(nameSender: String?) = """
        |*Olá $nameSender, tudo bem\?*
        |\/start\- Vamos começar
        |\/info \- Informações
        |\/bolos \- Receitas de bolos
        |\/pizzas \- Receitas de Pizzas
        |\/doces \- Receitas de Pizzas
        |\/salgados \- Receitas de Pizzas
    """.trimMargin()

    private fun pizza() = """
        |*Escolha sua preferida*
        |\/calabresa \- Pizza de calabresa
        |\/frango \- Pizza de frango com queijo
        |\/bacon \- Pizza de mussarela com bacon
        |\/inicio \- Voltar ao inicio
 
    """.trimMargin()
    private fun bolos() = """
        |*Escolha o seu preferido*
        |\/florestanegra \- Bolo floresta negra sem glúten
        |\/coco \- Bolo gelado de coco
        |\/chocolate \- Bolo pudim de chocolate
        |\/inicio \- Voltar ao inicio
 
    """.trimMargin()
    private fun doces() = """
        |*Escolha o seu preferido*
        |\/bombom \- Bombom de amendoim
        |\/maracuja \- Cheesecake de maracujá
        |\/pacoquinha \- Paçoquinha de amendoim e chocolate
        |\/inicio \- Voltar ao inicio
     """.trimMargin()

    private fun salgados() = """
        |*Escolha o seu preferido*
        |\/burrito \- Burrito de queijo com frango
        |\/coxinha \- Coxinha de frango
        |\/pastel \- Pastel de forno de batata doce
        |\/inicio \- Voltar ao inicio
     """.trimMargin()

    private fun sobre() = """
        |\ *Vou te passar passo a passo receitas saborosas de bolos,salgados, doces e pizzas*
        |\/inicio \- Voltar ao inicio
            """.trimMargin()



}


