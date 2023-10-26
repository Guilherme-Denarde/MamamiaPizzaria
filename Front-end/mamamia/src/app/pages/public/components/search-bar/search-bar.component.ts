import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.scss']
})
export class SearchBarComponent {
  term = '';
  @Output() search = new EventEmitter<string>();

  onSearch($event: Event) {
    $event.preventDefault();
    this.search.emit(this.term);
  }
}
