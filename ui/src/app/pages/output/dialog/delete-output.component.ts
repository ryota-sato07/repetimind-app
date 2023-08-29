import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

/**
 * ダイアログ: 引渡しデータ定義
 */
interface DialogData {
  outputId:    number;
  outputTitle: string;
}

/**
 * アウトプット: 削除確認ダイアログ
 */
@Component({
  templateUrl: './delete-output.component.html',
  styleUrls: ['./delete-output.component.scss']
})
export class DeleteOutputComponent implements OnInit {

  constructor(
    private dialogRef: MatDialogRef<DeleteOutputComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData
  ) { }

  ngOnInit() {
  }

  // -- [ Methods ] ------------------------------------------------------------
  /**
   * ダイアログを閉じる
   */
  onClose(): void {
    this.dialogRef.close();
  }
}
