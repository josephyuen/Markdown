package com.nzf.markdown.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.nzf.markdown.R
import com.nzf.markdown.view.OptionsView

/**
 * Created by joseph on 2017/11/15.
 */
class EditorFragment : Fragment(),TextWatcher{

    private lateinit var rootView : View
    private lateinit var optionGroup : OptionsView
    private lateinit var button : Button

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater!!.inflate(R.layout.fragment_home_editor,container,false)

        optionGroup = rootView.findViewById(R.id.ovg)

        return rootView
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        for(i in 0..5){
            button = Button(activity)
            button.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            button.text = "佳胜${i}"
        }
    }



    override fun afterTextChanged(s: Editable?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}