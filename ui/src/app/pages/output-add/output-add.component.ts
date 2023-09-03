import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-output-add',
  templateUrl: './output-add.component.html',
  styleUrls: ['./output-add.component.scss']
})
export class OutputAddComponent implements OnInit {

  // -- [ Properties ] ---------------------------------------------------------
  /**
   * フォーム入力の定義
   */
  outputForm = new FormGroup({
    'title':   new FormControl(null, Validators.required),
    'content': new FormControl(null, Validators.required)
  });

  constructor() { }
  ngOnInit() { }

  // -- [ Methods ] ------------------------------------------------------------
  /**
   * フォームを送信するイベントフック
   */
  onSubmit(): void {
    if (this.outputForm.valid) {
      alert('submit add button'); // TODO
    }
  }

}
