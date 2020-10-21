namespace task2
{
    partial class Task2
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.PictBoxTask2 = new System.Windows.Forms.PictureBox();
            this.Generate = new System.Windows.Forms.Button();
            this.FractPerc = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.FractSize = new System.Windows.Forms.TextBox();
            this.Clear = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.PictBoxTask2)).BeginInit();
            this.SuspendLayout();
            // 
            // PictBoxTask2
            // 
            this.PictBoxTask2.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.PictBoxTask2.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.PictBoxTask2.Location = new System.Drawing.Point(116, 12);
            this.PictBoxTask2.Name = "PictBoxTask2";
            this.PictBoxTask2.Size = new System.Drawing.Size(631, 569);
            this.PictBoxTask2.TabIndex = 0;
            this.PictBoxTask2.TabStop = false;
            // 
            // Generate
            // 
            this.Generate.Location = new System.Drawing.Point(11, 122);
            this.Generate.Name = "Generate";
            this.Generate.Size = new System.Drawing.Size(93, 29);
            this.Generate.TabIndex = 1;
            this.Generate.Text = "Generate";
            this.Generate.UseVisualStyleBackColor = true;
            this.Generate.Click += new System.EventHandler(this.Generate_Click);
            // 
            // FractPerc
            // 
            this.FractPerc.Location = new System.Drawing.Point(11, 35);
            this.FractPerc.Name = "FractPerc";
            this.FractPerc.Size = new System.Drawing.Size(93, 27);
            this.FractPerc.TabIndex = 2;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(3, 12);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(107, 20);
            this.label1.TabIndex = 3;
            this.label1.Text = "Enter precision";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(19, 69);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(72, 20);
            this.label2.TabIndex = 4;
            this.label2.Text = "Enter size";
            // 
            // FractSize
            // 
            this.FractSize.Location = new System.Drawing.Point(11, 89);
            this.FractSize.Name = "FractSize";
            this.FractSize.Size = new System.Drawing.Size(93, 27);
            this.FractSize.TabIndex = 5;
            // 
            // Clear
            // 
            this.Clear.Location = new System.Drawing.Point(11, 158);
            this.Clear.Name = "Clear";
            this.Clear.Size = new System.Drawing.Size(94, 29);
            this.Clear.TabIndex = 6;
            this.Clear.Text = "Clear";
            this.Clear.UseVisualStyleBackColor = true;
            this.Clear.Click += new System.EventHandler(this.Clear_Click);
            // 
            // Task2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(759, 593);
            this.Controls.Add(this.Clear);
            this.Controls.Add(this.FractSize);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.FractPerc);
            this.Controls.Add(this.Generate);
            this.Controls.Add(this.PictBoxTask2);
            this.MaximumSize = new System.Drawing.Size(777, 640);
            this.MinimumSize = new System.Drawing.Size(777, 640);
            this.Name = "Task2";
            this.Text = "Task2";
            ((System.ComponentModel.ISupportInitialize)(this.PictBoxTask2)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox PictBoxTask2;
        private System.Windows.Forms.Button Generate;
        private System.Windows.Forms.TextBox FractPerc;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox FractSize;
        private System.Windows.Forms.Button Clear;
    }
}

