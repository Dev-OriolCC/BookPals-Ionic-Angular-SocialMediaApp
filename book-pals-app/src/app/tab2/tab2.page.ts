import { Component, OnInit, ViewChild } from '@angular/core';
import { IonModal, SearchbarInputEventDetail, SearchbarCustomEvent } from '@ionic/angular';
import { OverlayEventDetail } from '@ionic/core/components'
import { BehaviorSubject, Observable } from 'rxjs';
import { UserService } from '../services/user.service';
import { DataState } from '../enum/datastate.enum';
import { CustomHttpResponse, UserState } from '../interface/appstates';
import { State } from '../interface/state';
import { User } from '../interface/user';


@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss']
})
export class Tab2Page implements OnInit {

  @ViewChild(IonModal) modal: IonModal | undefined;

  userState$!: Observable<State<CustomHttpResponse<UserState>>>;
  private dataSubject = new BehaviorSubject<CustomHttpResponse<UserState> | null>(null);
  

  private isLoading = new BehaviorSubject<boolean>(false);
  isLoading$ = this.isLoading.asObservable();
  readonly DataState = DataState;

  constructor(private userService: UserService) { }
  
  ngOnInit(): void {
    console.log("onInit method");
    
  }

  message = 'This modal example uses triggers to automatically open a modal when the button is clicked.';
  name: string | undefined;

  cancel() {
    this.modal?.dismiss(null, 'cancel');
  }

  confirm() {
    this.modal?.dismiss(this.name, 'confirm');
  }

  public data: string[] = [
    'Amsterdam',
    'Buenos Aires',
    'Cairo',
    'Geneva',
    'Hong Kong',
    'Istanbul',
    'London',
    'Madrid',
    'New York',
    'Panama City',
  ];
  public results: string[] = [...this.data];

  handleInput(event: any): void {
    const query = event.target.value?.toLowerCase() || '';
    this.results = this.data.filter((d) => d.toLowerCase().includes(query));
  }

  onWillDismiss(event: Event) {
    const ev = event as CustomEvent<OverlayEventDetail<string>>;
    if (ev.detail.role === 'confirm') {
      this.message = `Hello, ${ev.detail.data}!`;
    }
  }
  
  


}
