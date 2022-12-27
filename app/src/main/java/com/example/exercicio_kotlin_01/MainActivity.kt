package com.example.exercicio_kotlin_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.exercicio_kotlin_01.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    // No momento em que o viewBinding é ativado (viewBinding = true) no gradle,
    // o mesmo vai até a pasta de layout dentro de res (resources) e cria uma
    // sub classe com o nome do layout + Binding no final
    private lateinit var binding: ActivityMainBinding
    //O AcitvityMainBinding é uma classe que faz referência ao
    // layout activity_main. E é utilizado como uma instância para chamar os itens visuais do layout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Quando eu chamo minha variável declarada como lateinit (binding(ActivityMainBinding)),
        // e coloco = estou inicializando e atribuindo valor válido
        //Eu peço para o sistema inflar um layout (.inflate), quem é esse layout? ActivityMainBinding
        // (Mala com todos os componentes visuais) quem é que infla esse layout?
        // É o nosso inflador de layout (layoutInflater) e todas essas informações são o nosso valor válido de inicialização
        binding = ActivityMainBinding.inflate(layoutInflater)
        //Depois que nós já temos o nosso layout inflado, e inicializado,
        // ele está disponivel para ser acessado através da variável que foi incializada (binding )
        //Ao entender que a variavel binding tem acesso a todo o layout, vou utilizar ela, para definir meu layout raiz
        //Então eu crio uma constante de nome view, e digo pra essa contante que estou atribuindo um layout raiz (binding -> indica layout, root -> indica raiz) dentro dela.
        val view = binding.root
        //Para que eu apresente um layout na tela, é necessário o uso da função
        // setContentView() (configurando o conteúdo da visualização)
        //Então dentro da minha constante chamada view, eu tenho o valor de um
        // layout raiz, que é um tipo de conteúdo de visualização
        setContentView(view)
        //funcao custumizada para verificar quem esta no textView e quem vai entrar no txtView da lista
        chargeTextView()
    }

    private fun chargeTextView() {
        val list = listOf( "Bruno", "Caio", "Paulo")
        var currentItemIndex = 0

        binding.BotaoNext.setOnClickListener() {
            //if abaixo esta verificando se o indice for
            //maior ou igual ao tamanho da lista entao o indice volta a ser zero, para reiniciar a lista
            if (currentItemIndex >= list.size) {
                currentItemIndex = 0
            }
            //textView é apenas a caixa, o .text coloca texto na caixa
            // textView recebe a posiçao do item da lista a partir do indice que ta setado como zero.
            binding.textView.text = list [currentItemIndex]
            // linha abaixo adiciona +1 ao indice e consequentemente mostra o proximo item da lista
            currentItemIndex++
        }

    }

}