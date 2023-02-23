package com.appwork.kotlinpoc

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appwork.kotlinpoc.ui.theme.KotlinPOCTheme

val msg = Message("Android", "This is compose tutorial")

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      KotlinPOCTheme {
        Surface() {
          MessageCard(msg = msg)
        }
      }
    }
  }
}

data class Message(val title: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
  Row(
    modifier = Modifier.padding(all = 8.dp)
  ) {
    Image(
      painter = painterResource(id = R.drawable.ic_launcher_background),
      contentDescription = "",
      modifier = Modifier
        .size(42.dp)
        .clip(CircleShape)
        .border(1.5.dp, color = MaterialTheme.colors.error, shape = CircleShape)
    )

    AddHorizontalSpacer()

    Column {
      Text(
        text = msg.title,
        style = MaterialTheme.typography.subtitle1,
      )
      AddVerticalSpacer()
      Text(
        text = msg.body,
        style = MaterialTheme.typography.subtitle2,
      )
    }
  }

}

@Composable
fun AddHorizontalSpacer() {
  Spacer(modifier = Modifier.width(8.dp))
}

@Composable
fun AddVerticalSpacer() {
  Spacer(modifier = Modifier.height(8.dp))
}

@Preview(name = "My Preview", showBackground = true)
@Composable
fun DefaultPreview() {
  KotlinPOCTheme {
    MessageCard(msg = msg)
  }
}

@Preview(
  name = "Dark",
  showBackground = true,
  uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun NightPreview() {
  KotlinPOCTheme {
    MessageCard(msg = msg)
  }
}

