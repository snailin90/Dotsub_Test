import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { FileUploadService } from './fileupload.service';
import { FileUpload } from 'primeng/primeng';

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
  rootDirectoryPath: string = '';

  fileTitle: string = '';
  fileDescription: string = '';
  fileCreationDate: Date;
  @ViewChild('fileUpload', { static: false }) fileUploader: FileUpload;
  errorMessage: string = '';

  ngOnInit() {
    this.fileUploadService.getRootDirectoryPath().subscribe(
      response => {
        if (response && response.rootDirectoryPath) {
          this.rootDirectoryPath = response.rootDirectoryPath;

        }
      });

  }

  send(form) {
    if (form.valid === false) {
      this.errorMessage = 'You have to fill all the fields from the Form.';
      this.errorInformationDialog = true;
      return;

    }

    if (this.fileUploader.files.length === 0) {
      this.errorMessage = 'You have to select a file.';
      this.errorInformationDialog = true;
      return;
    }

    this.uploadInfo(form);
  }




  cancel(form) {
    form.reset();
    this.fileUploader.clear();
  }





  uploadInfo(form) {
    const file = this.fileUploader.files[0];
    this.uploadSpinnerModal = true;
    this.fileUploadService.upload(file, this.fileTitle, this.fileDescription, this.fileCreationDate.getTime()).subscribe(

      response => {
        this.uploadSpinnerModal = false;

        if (response.code === '000') {
          this.displayInformationDialog = true;
        } else {
          this.errorMessage = 'Not able to process the request. Please try again later.';
          this.errorInformationDialog = true;

        }
        this.fileUploader.clear();
        form.reset();

      },

      error => {
        this.uploadSpinnerModal = false;
        this.errorMessage = 'Not able to process the request. Please try again later.';
        this.errorInformationDialog = true;
        this.fileUploader.clear();
        form.reset();
      });

  }


}
