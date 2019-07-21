import { Component, OnInit } from '@angular/core';
import { FileUploadService } from "./fileupload.service";

@Component({
  selector: 'app-fileupload',
  templateUrl: './fileupload.component.html',
  styleUrls: ['./fileupload.component.css']
})
export class FileuploadComponent implements OnInit {

  constructor(public fileUploadService: FileUploadService) { }
  block: boolean = false;
  display: boolean = false;
  displayInformationDialog: boolean = false;
  ngOnInit() {


  }


 

  onUpload($event, fileUpload) {
    const file = $event.files[0];
    this.display = true;
    this.fileUploadService.upload(file).subscribe(

      response => {
        this.display = false;
        this.displayInformationDialog = true;
        console.log(response);
        fileUpload.clear();

      },

      error => {
        console.log(error);


      });

  }

  public testApi() {
    // debugger;
    // this.fileUploadService.pingServer().subscribe((data) => {
    //   console.log(data);
    // });
    this.display = true;
  }

}
