namespace lab7_1_2drawer
{
    partial class Form1
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
            this.drawingField = new System.Windows.Forms.PictureBox();
            this.task1 = new System.Windows.Forms.Button();
            this.task2 = new System.Windows.Forms.Button();
            this.numOfPoints = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.x1 = new System.Windows.Forms.TextBox();
            this.y1 = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.y2 = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.x2 = new System.Windows.Forms.TextBox();
            this.status = new System.Windows.Forms.Label();
            this.splitter1 = new System.Windows.Forms.Splitter();
            this.label7 = new System.Windows.Forms.Label();
            this.precision = new System.Windows.Forms.TextBox();
            this.label8 = new System.Windows.Forms.Label();
            this.scale = new System.Windows.Forms.TextBox();
            ((System.ComponentModel.ISupportInitialize)(this.drawingField)).BeginInit();
            this.SuspendLayout();
            // 
            // drawingField
            // 
            this.drawingField.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.drawingField.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.drawingField.Location = new System.Drawing.Point(106, 139);
            this.drawingField.Name = "drawingField";
            this.drawingField.Size = new System.Drawing.Size(621, 436);
            this.drawingField.TabIndex = 0;
            this.drawingField.TabStop = false;
            // 
            // task1
            // 
            this.task1.Location = new System.Drawing.Point(106, 5);
            this.task1.Name = "task1";
            this.task1.Size = new System.Drawing.Size(94, 29);
            this.task1.TabIndex = 1;
            this.task1.Text = "task1";
            this.task1.UseVisualStyleBackColor = true;
            this.task1.Click += new System.EventHandler(this.task1_Click);
            // 
            // task2
            // 
            this.task2.Location = new System.Drawing.Point(433, 5);
            this.task2.Name = "task2";
            this.task2.Size = new System.Drawing.Size(94, 29);
            this.task2.TabIndex = 1;
            this.task2.Text = "task2";
            this.task2.UseVisualStyleBackColor = true;
            this.task2.Click += new System.EventHandler(this.task2_Click);
            // 
            // numOfPoints
            // 
            this.numOfPoints.Location = new System.Drawing.Point(219, 37);
            this.numOfPoints.Name = "numOfPoints";
            this.numOfPoints.Size = new System.Drawing.Size(125, 27);
            this.numOfPoints.TabIndex = 2;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(106, 40);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(107, 20);
            this.label1.TabIndex = 3;
            this.label1.Text = "Num of points:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(106, 69);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(88, 20);
            this.label2.TabIndex = 3;
            this.label2.Text = "Line coords:";
            // 
            // x1
            // 
            this.x1.Location = new System.Drawing.Point(247, 70);
            this.x1.Name = "x1";
            this.x1.Size = new System.Drawing.Size(32, 27);
            this.x1.TabIndex = 2;
            // 
            // y1
            // 
            this.y1.Location = new System.Drawing.Point(312, 70);
            this.y1.Name = "y1";
            this.y1.Size = new System.Drawing.Size(32, 27);
            this.y1.TabIndex = 2;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(219, 73);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(26, 20);
            this.label3.TabIndex = 3;
            this.label3.Text = "X1";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(285, 73);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(25, 20);
            this.label4.TabIndex = 3;
            this.label4.Text = "Y1";
            // 
            // y2
            // 
            this.y2.Location = new System.Drawing.Point(312, 103);
            this.y2.Name = "y2";
            this.y2.Size = new System.Drawing.Size(32, 27);
            this.y2.TabIndex = 2;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(219, 106);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(26, 20);
            this.label5.TabIndex = 3;
            this.label5.Text = "X2";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(285, 106);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(25, 20);
            this.label6.TabIndex = 3;
            this.label6.Text = "Y2";
            // 
            // x2
            // 
            this.x2.Location = new System.Drawing.Point(247, 103);
            this.x2.Name = "x2";
            this.x2.Size = new System.Drawing.Size(32, 27);
            this.x2.TabIndex = 2;
            // 
            // status
            // 
            this.status.AutoSize = true;
            this.status.Location = new System.Drawing.Point(106, 421);
            this.status.Name = "status";
            this.status.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.status.Size = new System.Drawing.Size(0, 20);
            this.status.TabIndex = 4;
            this.status.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // splitter1
            // 
            this.splitter1.Location = new System.Drawing.Point(0, 0);
            this.splitter1.Name = "splitter1";
            this.splitter1.Size = new System.Drawing.Size(4, 587);
            this.splitter1.TabIndex = 5;
            this.splitter1.TabStop = false;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(435, 73);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(71, 20);
            this.label7.TabIndex = 3;
            this.label7.Text = "Precision:";
            // 
            // precision
            // 
            this.precision.Location = new System.Drawing.Point(512, 67);
            this.precision.Name = "precision";
            this.precision.Size = new System.Drawing.Size(125, 27);
            this.precision.TabIndex = 2;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(435, 43);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(47, 20);
            this.label8.TabIndex = 3;
            this.label8.Text = "Scale:";
            // 
            // scale
            // 
            this.scale.Location = new System.Drawing.Point(512, 37);
            this.scale.Name = "scale";
            this.scale.Size = new System.Drawing.Size(125, 27);
            this.scale.TabIndex = 2;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(836, 587);
            this.Controls.Add(this.scale);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.precision);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.splitter1);
            this.Controls.Add(this.status);
            this.Controls.Add(this.x2);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.y2);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.y1);
            this.Controls.Add(this.x1);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.numOfPoints);
            this.Controls.Add(this.task2);
            this.Controls.Add(this.task1);
            this.Controls.Add(this.drawingField);
            this.Name = "Form1";
            this.Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)(this.drawingField)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox drawingField;
        private System.Windows.Forms.Button task1;
        private System.Windows.Forms.Button task2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox x1;
        private System.Windows.Forms.TextBox y1;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox y2;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.TextBox x2;
        private System.Windows.Forms.TextBox numOfPoints;
        private System.Windows.Forms.Label status;
        private System.Windows.Forms.Splitter splitter1;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.TextBox precision;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.TextBox scale;
    }
}

