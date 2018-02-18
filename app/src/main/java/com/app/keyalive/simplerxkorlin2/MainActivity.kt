package com.app.keyalive.simplerxkorlin2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.ObservableEmitter
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//       cara ribet
//
//
//        Observable.create<String> { e: ObservableEmitter<String> ->
//
//
//        inputnamasaya.addTextChangedListener(object :TextWatcher{
//            override fun afterTextChanged(s: Editable?) {
//
//            }
//
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                e.onNext(p0.toString())
//            }
//        })
//        }
//        cara mudah
                RxTextView.textChanges(inputnamasaya)
                        .map { t: CharSequence -> t.toString()  }
                        .debounce(3,TimeUnit.SECONDS).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe { t: String? -> outputText.text=t }

    }
}
