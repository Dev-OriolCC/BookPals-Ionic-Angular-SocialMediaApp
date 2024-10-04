import { Component, OnInit, ViewChild } from '@angular/core';
import { IonModal } from '@ionic/angular';
import { OverlayEventDetail } from '@ionic/core/components'
import { UserService } from '../services/user.service';
import { BehaviorSubject, catchError, map, Observable, of, startWith } from 'rxjs';
import { CustomHttpResponse, UserState } from '../interface/appstates';
import { User } from '../interface/user';
import { State } from '../interface/state';
import { DataState } from '../enum/datastate.enum';

@Component({
  selector: 'app-tab3',
  templateUrl: 'tab3.page.html',
  styleUrls: ['tab3.page.scss']
})
export class Tab3Page implements OnInit {

  userState$!: Observable<State<CustomHttpResponse<UserState>>>;
  private dataSubject = new BehaviorSubject<CustomHttpResponse<UserState> | null>(null);
  
  private isLoading = new BehaviorSubject<boolean>(false);
  isLoading$ = this.isLoading.asObservable();
  readonly DataState = DataState;

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    console.log("Starting")
    this.userState$ =  this.userService.$user(1).pipe(
      map(response => {
        this.dataSubject.next(response);
        return { dataState: DataState.LOADED, appData: response };

      }),
      startWith({ dataState: DataState.LOADING }),
      catchError((error: string) => {
        return of({ dataState: DataState.ERROR, error: error})
      })
    )
    
  }

}
