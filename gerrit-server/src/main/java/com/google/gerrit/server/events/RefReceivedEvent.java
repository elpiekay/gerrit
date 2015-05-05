// Copyright (C) 2014 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.google.gerrit.server.events;

import com.google.gerrit.reviewdb.client.Project;
import com.google.gerrit.server.IdentifiedUser;

import org.eclipse.jgit.transport.ReceiveCommand;

public class RefReceivedEvent extends RefEvent {
  public ReceiveCommand command;
  public Project project;
  public IdentifiedUser user;

  public RefReceivedEvent() {
    super("ref-received");
  }

  @Override
  public Project.NameKey getProjectNameKey() {
    return project.getNameKey();
  }

  @Override
  public String getRefName() {
    return command.getRefName();
  }
}