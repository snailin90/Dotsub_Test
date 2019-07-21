import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';

@Injectable({
    providedIn: 'root',
})
export class FileUploadService {

    constructor(private httpClient: HttpClient) { }


    public upload(file: any): Observable<any> {
        console.log(file);
        const formData: FormData = new FormData();
        formData.append('file', file, file.name);
        return this.httpClient.post('/dotsub/api/file/upload', formData);

    }

    public pingServer(): Observable<any> {
        return this.httpClient.get('/dotsub/api/server/info');

    }

}
