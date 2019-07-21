import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'dotSub-UI';


  uploadFile(event) {
    console.log(event);
    alert('Hello from the Upload File');

  }
}
