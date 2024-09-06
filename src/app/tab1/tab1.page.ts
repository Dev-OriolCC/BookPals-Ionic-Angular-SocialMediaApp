import { Component } from '@angular/core';
@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page {
  isLoading: boolean = true;

  constructor() {
    
    setTimeout(() => { 
      this.isLoading = false;
    }, 3000);

  }

  handleRefresh(event: { target: { complete: () => void; }; }): void { 

    setTimeout(() => {
      event.target.complete();
    }, 0);
    console.log("Testing")
  }

}
