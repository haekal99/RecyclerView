package com.muhammadhaekal.recyclerview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.muhammadhaekal.recyclerview.adapter.AdapterTeamBola
import com.muhammadhaekal.recyclerview.databinding.ActivityMainBinding
import com.muhammadhaekal.recyclerview.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("Thibaut Courtois",R.drawable.courtois, "Penjaga Gawang", "2.00m", "Bre(Belgia)", "11 Mei 1992"))
        listPemain.add(Pemain("Karim Benzema",R.drawable.benzema, "Penyerang", "1.85m", "Lyon(Francis)", "19 Desember 1987"))
        listPemain.add(Pemain("Marcelo Vieira da Silva",R.drawable.marcello, "Belakang", "1.74m", "Rio de Janeiro(Brazil)", "12 Mei 1988"))
        listPemain.add(Pemain("Sergio Ramos Garcia",R.drawable.ramos, "Belakang", "1.84m", "Camas (Sevilla)", "30 Maret 1986"))
        listPemain.add(Pemain("Zinedine Yazid Zidane",R.drawable.zidan, "Pelatih", "1.85m", "Marsille(Prancis)", "23 Juni 1972"))

        binding.list.adapter = AdapterTeamBola(this,listPemain,object : AdapterTeamBola.OnClickListener{
            override fun detailData(item: Pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtNamaPemain)

                    val posisi = this.findViewById<TextView>(R.id.txtPosisi)
                    val tinggi = this.findViewById<TextView>(R.id.txtTinggi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txtTempatLahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txtTglLahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tgllahir.text = "${item?.tgllahir}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }
                }.show()
            }


        })
    }
}