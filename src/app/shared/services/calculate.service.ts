import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {NumberResult} from '../class/number-result';
import {NumberAdd} from '../class/number-add';

@Injectable({
  providedIn: 'root'
})
export class CalculateService {
  private addUrl: string;
  private currentNumberUrl: string;


  constructor(private http: HttpClient) {
    this.addUrl = 'http://localhost:8080/calculate/add';
    this.currentNumberUrl = 'http://localhost:8080/calculate/current';

  }

  public add(adder: NumberAdd): Observable<any> {
    console.log(adder);
    let body = new HttpParams();
    body = body.set('num', String(adder.num));
    return this.http.post<NumberResult>(this.addUrl, body, this._options());
  }

  public getCurrentValue(): Observable<NumberResult> {
    return this.http.get<NumberResult>(this.currentNumberUrl);
  }

  private _options(headerList: object = {}): any {
    return { headers: new HttpHeaders(Object.assign({ 'Content-Type': 'application/x-www-form-urlencoded' }, headerList)) };
  }

}
