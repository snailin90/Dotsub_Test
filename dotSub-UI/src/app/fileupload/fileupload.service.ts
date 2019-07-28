import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';


@Injectable({
    providedIn: 'root',
})
export class FileUploadService {

    constructor(private httpClient: HttpClient) { }


    public upload(file: any, title, description, creationDate): Observable<any> {
        const formData: FormData = new FormData();
        formData.append('file', file, file.name);
        formData.append('title', title);
        formData.append('description', description);
        formData.append('creationDate', creationDate);
        return this.httpClient.post('/dotsub/api/file/upload', formData);

    }

    public getRootDirectoryPath(): Observable<any> {
        return this.httpClient.get('/dotsub/api/file/root-directory');
    }


}
