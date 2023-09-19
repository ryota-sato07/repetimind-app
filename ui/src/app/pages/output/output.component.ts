import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import * as deleteDialog from './dialog';

@Component({
  selector: 'app-output',
  templateUrl: './output.component.html',
  styleUrls: ['./output.component.scss']
})
export class OutputComponent implements OnInit {

  constructor(
    private dialog: MatDialog,
    private router: Router,
  ) { }

  ngOnInit() {
  }

  // TODO: 削除
  items = ['a', 'b', 'c', 'd', 'e'];

  // -- [ Methods ] ------------------------------------------------------------
  /**
   * 登録ページ遷移
   */
  onSubmit(): void {
    this.router.navigate([ '/output/add' ]);
  }

  /**
   * 削除ダイアログを開く
   */
  openDialog(): void {
    this.dialog.open(deleteDialog.DeleteOutputComponent, {
      width:     '280px',
      maxWidth:  '280px',
      autoFocus: false,
      // TODO: Fix state data
      data: {
        outputId:    1,
        outputTitle: 'aの学習アウトプット'
      },
    });
  }

}
