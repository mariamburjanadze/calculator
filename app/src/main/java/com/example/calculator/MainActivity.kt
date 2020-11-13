package ge.msda.calculator2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import com.example.calculator.R
import com.example.calculator.R.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    private var operand: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        resultTextView = findViewById(id.resultTextView)

        findViewById<TextView>(id.btnClear).setOnClickListener{
            operand = 0.0
            operation = ""
            resultTextView.text = ""
        }

        DEL.setOnClickListener() {
            val text = resultTextView.text.toString().removeSuffix(".0")
            if (text.isNotEmpty()) {
                resultTextView.text = text.dropLast(1).removeSuffix(".0")
            } else if (text.isEmpty()) {
                resultTextView.text = operand.toString().removeSuffix(".0")
            }
        }



    }

    fun numberClick(view: View) {

        if (view is TextView) {

            var result: String = resultTextView.text.toString()
            val number: String = view.text.toString()

            if (result == "0") {
                result = ""
            }

            resultTextView.text = result + number

        }

    }

    fun operationClick(view: View) {

        if (view is TextView) {

            if (!TextUtils.isEmpty(resultTextView.text)) {
                operand = resultTextView.text.toString().toDouble()
            }

            operation = view.text.toString()

            resultTextView.text = ""

        }

    }

    fun equalsClick(view: View) {

        val secOperandText: String = resultTextView.text.toString()
        var secOperand: Double = 0.0

        if (!TextUtils.isEmpty(secOperandText)) {
            secOperand = secOperandText.toDouble()
        }

        when (operation) {
            "+" -> resultTextView.text = (operand + secOperand).toString().removeSuffix(".0")
            "-" -> resultTextView.text = (operand - secOperand).toString().removeSuffix(".0")
            "*" -> resultTextView.text = (operand * secOperand).toString().removeSuffix(".0")
            "/" -> resultTextView.text = (operand / secOperand).toString().removeSuffix(".0")
        }

    }

}
