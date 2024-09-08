import { Component } from '@angular/core';
import { addIcons } from 'ionicons';
import { ellipse } from 'ionicons/icons';

interface Item {
  name: string;
  unread: boolean;
}
@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss']
})
export class Tab2Page {
  public names = [
    'Jonathan Venegas',
    'Charlie Brown',
    'James Cortez',
    'Ellie Lawrence',
    'Francisco Marshall',
    'Walter White',
    'Julio Sanchez',
    'Max Charles',
    'Curt Conner',
    'Chris Morrison',
  ];
  public items: Item[] = [];

  constructor() {
    addIcons({ ellipse });
  }

  ngOnInit() {
    this.addItems(2);
  }

  chooseRandomName() {
    return this.names[Math.floor(Math.random() * this.names.length)];
  }

  addItems(count: number, unread: boolean = false) {
    for (let i = 0; i < count; i++) {
      this.items.unshift({
        name: this.chooseRandomName(),
        unread: unread,
      });
    }
  }

  handleRefresh(event: { target: { complete: () => void; }; }) {
    setTimeout(() => {
      this.addItems(1, true);
      event.target.complete();
    }, 2000);
  }

}
