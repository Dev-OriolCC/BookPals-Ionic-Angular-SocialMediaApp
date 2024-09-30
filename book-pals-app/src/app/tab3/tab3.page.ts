import { Component, ViewChild } from '@angular/core';
import { IonModal } from '@ionic/angular';
import { OverlayEventDetail } from '@ionic/core/components'
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-tab3',
  templateUrl: 'tab3.page.html',
  styleUrls: ['tab3.page.scss']
})
export class Tab3Page {

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    console.log("Starting")
    this.userService.$user(1).subscribe(data => {
      console.log(data);
    })
  }

}
