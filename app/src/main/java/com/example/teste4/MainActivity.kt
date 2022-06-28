package com.example.teste4

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Eventos>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>
    lateinit var headingtwo: Array<String>
    lateinit var headingthree: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val actionBar= supportActionBar
        actionBar!!.title= "Feed"

        setContentView(R.layout.activity_main)


        imageId= arrayOf(
            R.drawable.drift,
            R.drawable.feicotur,
            R.drawable.ps,
            R.drawable.fogueira,
            R.drawable.sumer
        )

        heading= arrayOf(
            "Campeonato Brasiliense de Drift",
            "FeicoTur",
            "Peça Show",
            "1ª ETAPA – DONA LOURDES",
            "Summer Game Fest"
        )

        headingtwo= arrayOf(
            "Data: 11 e 12 de Junho de 2022\n" +
                    "Endereço: Taguaparque/Taguatinga\n" +
                    "Acessibilidade: Metro\n" +
                    "Entrada: R\$ 30.00\n" +
                    "Classificação: Livre\t\n" +
                    "Horario: 08h00 até 18h00",
            "Data: 2 a 5 de Junho\n" +
                    "Endereço: Estacionamento do Estadio Augustinho Lima/ Sobradinho\n" +
                    "Entrada: Gratuito\n" +
                    "Classificação: Livre\t\n" +
                    "Horario: 20h",
            "Data: 11/06/2022\n" +
                    "Endereço: Complexo Cultural de Samambaia\n" +
                    "Acessibilidade: Metro\n" +
                    "Entrada: Gratuito\n" +
                    "Classificação: Livre\t\n" +
                    "Horario: 18H30\n",
            "Data: 4 e 5 de junho \n" +
                    "Endereço: Estacionamento ao lado da Administração Regional do Paranoá\n" +
                    "Entrada: Gratuito\n" +
                    "Classificação: Livre\t\n" +
                    "Horario: 20h",
            "Data: 09/06/2022\n" +
                    "Local: Canal thegameawards/YouTube\n" +
                    "Entrada: Gratuito\n" +
                    "Classificação: Livre\t\n" +
                    "Horario: 14h"
        )

        headingthree= arrayOf(
            "No dia 11 e 12 de Junho de 2022, o Taguaparque receberá os melhores pilotos de Drift do país para continuar à Temporada 2022 do Campeonato Brasiliense de Drift. Você não vai perder essa, né?",
            "A FEICOTUR tem o propósito de reunir expositores da Industria, Comércio e Turismo a nível local e Regional durante três dias com a finalidade de aproximar empresários, consumidores e a população em geral, e contará com a apresentação de Rio Negro e Solimões, Lauana Prado, Juliano Son e muito mais.",
            "Um projeto pensado e feito para o Complexo Cultural Samambaia, fomentando o diálogo, arte, cultura, cidadania e entretenimento por meio de uma programação super divertida de TRÊS DIAS fruto da interação entre artistas, lideranças locais, crianças e adolescentes da comunidade.",
            "Uma das atrações da 2° edição de circuito de quadrilhas juninas do Distrito Federal. Vai ser perfeito, não perca!",
            "Uma vitrine ao vivo de anúncios e jogos para vários setores, apresentada por Geoff Keighley"
        )

        newRecyclerView= findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager= LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList= arrayListOf<Eventos>()
        getUserdata()
    }

    private fun getUserdata() {
        for (i in imageId.indices){
            val eventos = Eventos(imageId[i],heading[i],headingtwo[i], headingthree[i])
            newArrayList.add(eventos)
        }

        newRecyclerView.adapter= MyAdapter(newArrayList)
    }
}

private fun ActionBar?.setDesplayoptions(displayShowCustom: Int) {

}
