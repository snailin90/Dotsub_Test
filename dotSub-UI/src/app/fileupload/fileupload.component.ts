import { Component, OnInit } from '@angular/core';
import { FileUploadService } from './fileupload.service';

@Component({
  selector: 'app-fileupload',
  templateUrl: './fileupload.component.html',
  styleUrls: ['./fileupload.component.css']
})
export class FileuploadComponent implements OnInit {

  constructor(public fileUploadService: FileUploadService) { }
  block: boolean = false;
  uploadSpinnerModal: boolean = false;
  displayInformationDialog: boolean = false;
  errorInformationDialog: boolean = false;
  rootDirectoryPath: String = '';
  ngOnInit() {
    this.fileUploadService.getRootDirectoryPath().subscribe(
      response => {
        if (response && response.rootDirectoryPath) {
          this.rootDirectoryPath = response.rootDirectoryPath;

        }
      });

  }




  onUpload($event, fileUpload) {
    const file = $event.files[0];
    this.uploadSpinnerModal = true;
    this.fileUploadService.upload(file).subscribe(

      response => {
        this.uploadSpinnerModal = false;

        if (response.code === '000') {
          this.displayInformationDialog = true;
        } else {
          this.errorInformationDialog = true;

        }
        fileUpload.clear();

      },

      error => {
        this.uploadSpinnerModal = false;
        this.errorInformationDialog = true;



      });

  }


}
