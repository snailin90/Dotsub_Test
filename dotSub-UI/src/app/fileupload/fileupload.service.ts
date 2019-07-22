import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';


@Injectable({
    providedIn: 'root',
})
export class FileUploadService {

    constructor(private httpClient: HttpClient) { }


    public upload(file: any): Observable<any> {
        const formData: FormData = new FormData();
        formData.append('file', file, file.name);
        return this.httpClient.post('/dotsub/api/file/upload', formData);

    }


}
