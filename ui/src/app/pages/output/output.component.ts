import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-output',
  templateUrl: './output.component.html',
  styleUrls: ['./output.component.scss']
})
export class OutputComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  // TODO: 削除
  items = ['a','b','c','d','e'];

}
