package com.jaewook.persistentbottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.jaewook.persistentbottomsheet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 전역 변수로 바인딩 객체 선언
    private var mBinding : ActivityMainBinding? = null

    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    private lateinit var sheetBehavior : BottomSheetBehavior<View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 자동 생성된 뷰 바인딩 클래스에서의 inflate라는 메서드를 활용해서
        // 액티비티에서 사용할 바인딩 클래스의 인스턴스 생성
        mBinding = ActivityMainBinding.inflate(layoutInflater)

        // getRoot 메서드로 레이아웃 내부의 최상위 위치 뷰의 인스턴스를 활용하여 생성된 뷰를 액티비티에 표시함
        setContentView(binding.root)

        // 이제부터 binding 바인딩 변수를 활용하여 마음껏 xml파일 내의 뷰 id 접근이 가능해짐
        sheetBehavior = BottomSheetBehavior.from(binding.bottomScrollView)

        sheetBehavior.addBottomSheetCallback(BSCB)

        binding.textview.setOnClickListener(SOCL)
    }

    val BSCB : BottomSheetBehavior.BottomSheetCallback = object : BottomSheetBehavior.BottomSheetCallback() {
        override fun onStateChanged(bottomSheet: View, newState: Int) {
            when (newState) {
                BottomSheetBehavior.STATE_COLLAPSED -> {
                }
                BottomSheetBehavior.STATE_DRAGGING -> {
                }
                BottomSheetBehavior.STATE_EXPANDED -> {
                }
                BottomSheetBehavior.STATE_HIDDEN -> {
                }
                BottomSheetBehavior.STATE_SETTLING -> {
                }
            }
        }

        override fun onSlide(bottomSheet: View, slideOffset: Float) {

        }
    }

    val SOCL : View.OnClickListener = object : View.OnClickListener {
        override fun onClick(p0: View?) {
            sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }

    override fun onDestroy() {
        // onDestroy에서 binding class 인스턴스 참조를 정리해주어야 한다,
        mBinding = null
        super.onDestroy()
    }
}