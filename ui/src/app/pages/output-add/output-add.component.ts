import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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

  constructor(
    private router: Router,
  ) { }
  ngOnInit() { }

  // -- [ Methods ] ------------------------------------------------------------
  /**
   * フォームを送信するイベントフック
   */
  onSubmit(): void {
    if (this.outputForm.valid) {
      alert('アウトプットが登録されました。'); // TODO
      this.router.navigate([ '/output' ]);
    }
  }

}
