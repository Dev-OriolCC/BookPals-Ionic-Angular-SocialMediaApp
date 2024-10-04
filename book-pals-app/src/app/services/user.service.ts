import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CustomHttpResponse, UserState } from '../interface/appstates';
import { User } from '../interface/user';
import { catchError, Observable, tap, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private readonly server: string = "http://localhost:8080/book-pals/api/v1"
  constructor(private http: HttpClient) { }

  $user = (id: number) => <Observable<CustomHttpResponse<UserState>>>
    this.http.get<CustomHttpResponse<User>>(`${this.server}/user/${id}`, {})
      .pipe(
        tap(console.log),
        catchError(this.handleError)
      )
  


  private handleError(error: HttpErrorResponse): Observable<any> {
    let errorMessage: string;
    if (error.error instanceof ErrorEvent) {
      // Frontend Error
      errorMessage = `[ERROR] A client error occurred: ${error.error.message}`;
    } else {
      if (error.error.reason) {
        // Backend Error
        errorMessage = error.error.reason;
      } else {
        // Generic Error
        errorMessage = `[ERROR] An error occurred: ${error.status}`;
      }
    }
    return throwError(() => errorMessage);
  }
}
