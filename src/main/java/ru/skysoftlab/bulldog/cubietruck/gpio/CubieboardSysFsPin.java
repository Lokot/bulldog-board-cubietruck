/*******************************************************************************
 * Copyright (c) 2016 Silverspoon.io (silverspoon@silverware.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.skysoftlab.bulldog.cubietruck.gpio;

import io.silverspoon.bulldog.linux.sysfs.SysFsPin;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CubieboardSysFsPin extends SysFsPin {
   private static final String directory = "/sys/class/gpio";

   private String fsName;
   private boolean interrupt;

   public CubieboardSysFsPin(int pin, String fsName, boolean interrupt) {
      super(pin);
      this.fsName = fsName;
      this.interrupt = interrupt;
   }

   @Override
   public Path getPinDirectory() {
      return Paths.get(directory, "/gpio" + fsName + "/");
   }

   @Override
   public void setEdge(String edge) {
      if (interrupt) {
         super.setEdge(edge);
      }
   }
}
